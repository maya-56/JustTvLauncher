package crazyboyfeng.justTvLauncher.browse

import android.content.Context
import android.content.Intent
import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

object IdNumberWriteHelper {
    const val CHANGE_ID_BROADCAST_INTENT_NAME = "com.circle.bleservice.ID_CHANGED"
    fun writeID(context: Context, id: String) {
        val sdCard = Environment.getExternalStorageDirectory()
        val dir = File(sdCard.absolutePath)
        //        dir.mkdirs();
        val file = File(dir, "ID_NUMBER")
        try {
            val f = FileOutputStream(file)
            f.write(id.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val intent = Intent(CHANGE_ID_BROADCAST_INTENT_NAME)
        context.sendBroadcast(intent)
    }

    fun readID(): String {
        val id = ""
        val sdCard = Environment.getExternalStorageDirectory()
        val dir = File(sdCard.absolutePath)
        val file = File(dir, "ID_NUMBER")
        try {
            val f = FileInputStream(file)
            var u = 0
            val bytes = ByteArray(128)
            var i = 0
            while (u != -1) {
                u = f.read()
                bytes[i] = u.toByte()
                i++
            }
            bytes[i] = '\u0000'.code.toByte()
            return String(bytes, 0, i - 1, charset("UTF-8"))
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return id
    }
}
