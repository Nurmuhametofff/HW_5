class Notes (
    id: Int,
    var isDelete: Boolean = false,
    val title: String = "",
    val text: String = "",
    val date: Int = 0,
    val comments: MutableList<Comment> = mutableListOf()
    ): Node(id){
    override fun toString(): String {
        return "id notes = $id $text"
    }
    }