package map.viewer

import geoscript.render.Map as GeoScriptMap
import geoscript.layer.Shapefile
import static geoscript.style.Symbolizers.*

//import grails.gorm.transactions.Transactional
//
//@Transactional
class MapService
{
	def shp = new Shapefile('world_adm0.shp')
	
	def getTile( def params )
	{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream()
		int width = params.WIDTH?.toInteger() ?: 256
		int height = params.HEIGHT?.toInteger() ?: 256

//		BufferedImage image = new BufferedImage(
//			width,
//			height,
//			BufferedImage.TYPE_INT_ARGB )
//
//		String format = params.FORMAT - 'image/'
//
//		ImageIO.write( image, format, buffer )
		def coords = params.BBOX?.split( ',' )?.collect { it.toDouble() }
		
		shp.style = stroke( color: 'green' ) + fill( opacity: 0.5 )
		
		def map = new GeoScriptMap(
			width: width,
			height: height,
			bounds: [ coords[1], coords[0], coords[3], coords[2] ],
			proj: params.CRS,
			layers: [
				shp
			]
		)
		
		map.render( buffer )
		map.close()
		
		[ contentType: params.FORMAT, file: buffer.toByteArray() ]
	}
}
