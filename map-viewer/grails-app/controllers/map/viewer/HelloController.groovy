package map.viewer

class HelloController {

    def index() {
        def name = params.name ?: 'World'
//        render text: "Hello World: ${new Date()}"
        [message: "Hello ${name}: ${new Date()}"]
    }
}
