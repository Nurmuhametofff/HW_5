import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun addComment() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        val result = noteTest.comments.contains(commentTest)
        assertTrue(result)
    }
    @Test(expected = NoteNotFoundException::class)
    fun addCommentException() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(2, commentTest)

    }

    @Test
    fun delete() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        serviceTest.delete(1)
        val result = noteTest.isDelete
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteException() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        serviceTest.delete(2)

    }

    @Test
    fun deleteComment() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.deleteComment(1, 1)
        val result = commentTest.isDelete
        assertTrue(result)
    }
    @Test(expected = NoteNotFoundException::class)
    fun deleteCommentExceptionNote() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.deleteComment(2, 1)

    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteCommentExceptionComment() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.deleteComment(1, 2)

    }

    @Test
    fun updateComment() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        val updateComment = Comment(id = 1, text = "update comment")
        serviceTest.updateComment(1, 1, updateComment)
        val result = noteTest.comments[0]
        assertTrue(result == updateComment)
    }
    @Test(expected = NoteNotFoundException::class)
    fun updateCommentException() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        val updateComment = Comment(id = 1, text = "update comment")
        serviceTest.updateComment(1, 2, updateComment)

    }

    @Test
    fun restoreComment() {

        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.deleteComment(1, 1)
        serviceTest.restoreComment(1, 1)
        val result = commentTest.isDelete
        assertFalse(result)
        }

    @Test(expected = NoteNotFoundException::class)
    fun restoreCommentExceptionIsDelete() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.restoreComment(1, 1)

    }

    @Test(expected = NoteNotFoundException::class)
    fun restoreCommentException() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.restoreComment(1, 2)
        val result = commentTest.isDelete
        assertFalse(result)
    }


    @Test
    fun getByIdCom() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        val result = serviceTest.getByIdCom(1, 1)
        assertTrue(result == commentTest)
    }
    @Test(expected = NoteNotFoundException::class)
    fun getByIdComExceptionComment() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.getByIdCom(1,5)
    }
    @Test(expected = NoteNotFoundException::class)
    fun getByIdComExceptionNote() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val commentTest = Comment(text = "comment test")
        serviceTest.addComment(1, commentTest)
        serviceTest.getByIdCom(5,1)
    }
}