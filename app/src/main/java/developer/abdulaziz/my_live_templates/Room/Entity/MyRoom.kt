package developer.abdulaziz.my_live_templates.Room.Entity

@Entity
class MyRoom {
    @PrimaryKey(autoGenerate = true)
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