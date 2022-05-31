class Notes(
    id: Int = 1,
    var isDelete: Boolean = false,
    val title: String = "",
    val text: String = "",
    val date: Int = 0,
    val comments: MutableList<Comment> = mutableListOf(),
) : Node(id) {
    override fun toString(): String {
        if (!isDelete){
            return "notes id = $id  and text = $text and comment ${comments.toString()}"
        }
        return "note deleted"
    }
}