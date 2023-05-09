package com.example.todolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    val FILENAME = "listinfo.dat"
// writing data to the file and should be closed
    fun writeData(item : ArrayList<String>, context : Context){
        var fos : FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)
        var oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }
 // reading data from the file method
    fun readData(context:Context):ArrayList<String>{
        var itemList : ArrayList<String>

        try{
            var fis :FileInputStream = context.openFileInput(FILENAME)
            var ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>
        } catch (e :FileNotFoundException){
            itemList = ArrayList()
        }




     return itemList

    }
}