data class Comment(
    var id: Int = 1,
    val text: String = "",
    val data: Int = 0,
    var isDelete: Boolean = false

){
    override fun toString(): String {
        if (!isDelete){
            return "$text"
        }
        return "comment deleted"
    }
}