

fun main() {
    val service = NoteService()
    service.add(Notes(text = "first"))
    println(service.getById(1))
    println(service.getById(2))
    service.update(Notes(1, text = "second"))
    println(service.getById(1))
    println( service.getByIdCom(5,7))







}