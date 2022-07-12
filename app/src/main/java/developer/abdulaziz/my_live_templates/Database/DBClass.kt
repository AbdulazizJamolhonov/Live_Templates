package developer.abdulaziz.my_live_templates.Database

class DBClass {
    var id: Int? = null
    var name: String? = null

    constructor(id: Int?, name: String?) {
        this.id = id
        this.name = name
    }

    constructor(name: String?) {
        this.name = name
    }

    constructor()
}