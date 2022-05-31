import org.junit.Test

import org.junit.Assert.*

class CRUDserviceTest {


    @Test
    fun add() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        val valueResult = serviceTest.add(noteTest)
        val result = noteTest
        assertTrue(result == valueResult)
    }

    @Test
    fun getByIdTrue() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val valueResult = serviceTest.getById(1)
        val result = noteTest
        assertTrue(result == valueResult)
    }
    @Test
    fun getByIdFalse() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val valueResult = serviceTest.getById(10)
        val result = noteTest
        assertFalse(result == valueResult)
    }

    @Test
    fun updateTrue() {
        val serviceTest = NoteService()
        val noteTest = Notes(text = "test")
        serviceTest.add(noteTest)
        val noteTest2 = Notes(id = 1, text = "test2")
        serviceTest.update(noteTest2)
        val result = noteTest2
        assertTrue(result == serviceTest.getById(1))
    }


}