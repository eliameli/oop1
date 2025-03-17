











// общий класс
abstract class LibraryItem(
    val id: Int,
    var isAvailable: Boolean,
    val name: String
) {
    abstract fun getBriefInfo(): String
    abstract fun getDetailedInfo(): String
}

// классы для типов
class Book(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val author: String,
    val pages: Int
) : LibraryItem(id, isAvailable, name) {
    override fun getBriefInfo() = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo() = "Книга: $name ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}

class Newspaper(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val issueNumber: Int
) : LibraryItem(id, isAvailable, name) {
    override fun getBriefInfo() = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo() = "Выпуск: $issueNumber газеты $name с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
}

class Disk(
    id: Int,
    isAvailable: Boolean,
    name: String,
    val diskType: String
) : LibraryItem(id, isAvailable, name) {
    override fun getBriefInfo() = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"
    override fun getDetailedInfo() = "$diskType $name доступна: ${if (isAvailable) "Да" else "Нет"}"
}








// то что было в мейн и я поменял
class Library(private val items: List<LibraryItem>) {

    // запуск библио
    fun start() {
        while (true) {
            println("Выберите тип объекта:\n1. Показать книги\n2. Показать газеты\n3. Показать диски\n0. Выход")
            when (readLine()?.toIntOrNull()) {
                1 -> showItems(items.filterIsInstance<Book>())
                2 -> showItems(items.filterIsInstance<Newspaper>())
                3 -> showItems(items.filterIsInstance<Disk>())
                0 -> return
                else -> println("Неверный выбор.")
            }
        }
    }
    // список
    private fun <T : LibraryItem> showItems(items: List<T>) {
        items.forEachIndexed { index, item -> println("${index + 1}. ${item.getBriefInfo()}") }
        println("Выберите объект (номер) или 0 для возврата в меню:")
        val objectNumber = readLine()?.toIntOrNull()

        if (objectNumber == 0) return

        if (objectNumber != null && objectNumber in 1..items.size) {
            performAction(items[objectNumber - 1])
        } else {
            println("Неверный номер объекта.")
        }
    }

    // doing
    private fun performAction(item: LibraryItem) {
        println("Выберите действие:\n1. Взять домой\n2. Читать в читальном зале\n3. Показать подробную информацию\n4. Вернуть\n0. Вернуться в меню")
        when (readLine()?.toIntOrNull()) {
            1 -> if (item is Disk || item is Book) performTakeHome(item) else println("Нельзя взять газету домой.")
            2 -> if (item is Book || item is Newspaper) performReadInHall(item) else println("Нельзя пользоваться диском в читальном зале.")
            3 -> println(item.getDetailedInfo())
            4 -> if (!item.isAvailable) returnItem(item) else println("Объект уже доступен.")
            0 -> return
            else -> println("Неверный выбор.")
        }
    }


    private fun performTakeHome(item: LibraryItem) {
        if (item.isAvailable) {
            item.isAvailable = false
            println("${item.getBriefInfo()} взяли домой.")
        } else {
            println("Объект недоступен для взятия домой.")
        }
    }


    private fun performReadInHall(item: LibraryItem) {
        if (item.isAvailable) {
            item.isAvailable = false
            println("${item.getBriefInfo()} можно читать в читальном зале.")
        } else {
            println("Объект недоступен для чтения в зале.")
        }
    }


    private fun returnItem(item: LibraryItem) {
        item.isAvailable = true
        println("${item.getBriefInfo()} возвращен.")
    }
}











fun main() {
    //создание элементов
    val items = listOf(
        Book(1, true, "Маугли", "Джозеф Киплинг", 202),
        Book(11, true, "Звездные войны", "Джордж Лукас", 401),
        Newspaper(2, true, "Сельская жизнь", 794),
        Newspaper(21, true, "Семья", 23),
        Disk(3, true, "Дэдпул и Росомаха", "DVD"),
        Disk(31, true, "Один Дома", "CD")
    )

    // запуск
    Library(items).start()
}
