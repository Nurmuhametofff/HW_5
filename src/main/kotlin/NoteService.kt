class NoteNotFoundException : RuntimeException()

class NoteService : CRUDservice<Notes>() {
    fun addComment(noteID: Int, comment: Comment): Boolean {
        if (elements.contains(getById(noteID))) {
            comment.id = getById(noteID)?.id!!
            getById(noteID)?.comments?.add(comment)
            return true
        }
        return false
    }

    fun delete(noteId: Int) {
        getById(noteId)?.isDelete = true
    }

    fun deleteComment(commentId: Int) {
        val value = getById(commentId)
        if (elements.contains(value)) {
            for ((index, elem) in value?.comments?.withIndex()!!) {
                if (commentId == elem.id) {
                    elem.isDelete = true
                }
            }
        }

    }


    fun getByIdCom(id: Int): Comment? {
        return getById(id)?.comments?.find { it.id == id }
    }


}