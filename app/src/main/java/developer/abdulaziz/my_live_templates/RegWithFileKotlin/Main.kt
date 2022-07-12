package developer.abdulaziz.my_live_templates.RegWithFileKotlin

fun main() {
    while (true) {
        println("1 - Add User\n2 - Show User\n3 - Edit User\n4 - Search User\n5 - Remove User")
        when (Scanner(System.`in`).nextInt()) {
            1 -> MyService().add()
            2 -> MyService().view()
            3 -> MyService().edit()
            4 -> MyService().search()
            5 -> MyService().remove()
        }
    }
}

class MyService : MyInter {
    private val scanner = Scanner(System.`in`)
    override fun add() {
        println("Write Users Name: ")
        val name = scanner.next()
        println("Write Users Age: ")
        val age = scanner.next()
        val list = readFile()
        list.add(Users(name, age))
        writeFile(list)
        println("Saved!")
    }

    override fun view() = readFile().forEach { println("${list.indexOf(it)} - User: $it\n") }

    override fun edit() {
        println("Qaysi birini tahrirlaymiz: ")
        view()
        val edit = scanner.nextInt()
        println("Write New Users Name: ")
        val name = scanner.next()
        println("Write New Users Age: ")
        val age = scanner.next()
        val list = readFile()
        list[edit] = Users(name, age)
        writeFile(list)
        println("Edited!")
    }

    override fun search() {
        println("Qidirmoqchi bo'lgan Userni ismi yoki yoshini kiriting: ")
        val search = scanner.next()
        val list = readFile()
        var index = -1
        for (user in list) {
            if (search == user.name || search == user.age) {
                index = list.indexOf(user)
                break
            }
        }
        println(
            if (index != -1) "$index - User: ${list[index]}"
            else "User topilmadi!"
        )
    }

    override fun remove() {
        println("Qaysi birini o'chiramiz: ")
        view()
        val remove = scanner.nextInt()
        val list = readFile()
        list.removeAt(remove)
        writeFile(list)
        println("Removed!")
    }

    override fun readFile(): ArrayList<Users> =
        Gson().fromJson(
            File("file.txt").readLines()[0],
            object : TypeToken<ArrayList<Users>>() {}.type
        )

    override fun writeFile(list: ArrayList<Users>) {
        val fileWriter = FileWriter("file.txt")
        fileWriter.write(Gson().toJson(list))
        fileWriter.close()
    }
}

class Users(var name: String, var age: String) {
    override fun toString(): String = "Name = $name, Age = $age"
}

interface MyInter {
    fun add()
    fun view()
    fun edit()
    fun search()
    fun remove()

    fun readFile(): ArrayList<Users>
    fun writeFile(list: ArrayList<Users>)
}