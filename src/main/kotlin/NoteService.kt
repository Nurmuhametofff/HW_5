class NoteNotFoundException(massage: String) : RuntimeException(massage)

class NoteService : CRUDservice<Notes>() {
    private var uniqueId = 1

    fun addComment(noteID: Int, comment: Comment): Boolean {
        if (elements.contains(getById(noteID))) {
            comment.id = uniqueId++
            getById(noteID)?.comments?.add(comment)
            return true
        }
        throw NoteNotFoundException("not found")
    }

    fun delete(noteId: Int): Boolean {
        if (elements.contains(getById(noteId))) {
            getById(noteId)?.isDelete = true
            return true
        }
        throw NoteNotFoundException("not found")
    }

    fun deleteComment(noteId: Int, commentId: Int): Boolean {
        val value = getById(noteId)
        if (elements.contains(value) && getByIdCom(noteId, commentId)?.id == commentId) {
            for ((index, elem) in value?.comments?.withIndex()!!) {
                if (commentId == elem.id) {
                    elem.isDelete = true
                    return true
                }
            }
        }
        throw NoteNotFoundException("not found")
    }

    fun updateComment(noteId: Int, commentId: Int, comment: Comment): Boolean {
        val value = getById(noteId)
        if (elements.contains(value) && getByIdCom(noteId, commentId)?.id == commentId) {
            for ((index, elem) in value?.comments?.withIndex()!!) {
                if (commentId == elem.id) {
                    if (!elem.isDelete) {
                        val newComment = comment.copy(id = elem.id, data = elem.data)
                        value.comments.remove(elem)
                        value.comments.add(newComment)
                        return true
                    }

                }
            }
        }
        throw NoteNotFoundException("not found")
    }

    fun restoreComment(noteId: Int, commentId: Int): Boolean {
        val value = getById(noteId)
        if (elements.contains(value) && getByIdCom(noteId, commentId)?.id == commentId) {
            for ((index, elem) in value?.comments?.withIndex()!!) {
                if (commentId == elem.id) {
                    if (elem.isDelete) {
                        elem.isDelete = false
                        return true
                    }
                }
            }
        }
        throw NoteNotFoundException("Not found")
    }


    fun getByIdCom(noteId: Int, commentId: Int): Comment? {
        if(getById(noteId)?.comments?.find { it.id == commentId } != null){
            return getById(noteId)?.comments?.find { it.id == commentId }
        }
        throw NoteNotFoundException("Not found")
    }


}