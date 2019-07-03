package map.viewer

class MapWidgetController
{
	MapService mapService
	
	def index()
	{
	
	}
	
	def getTile()
	{
		println params
		
		render mapService.getTile( params )
	}
}
