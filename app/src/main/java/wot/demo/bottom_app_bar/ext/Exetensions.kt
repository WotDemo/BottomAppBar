package wot.demo.bottom_app_bar

import android.content.Context
import android.widget.Toast

/**
 * @Description 扩展
 * @Author Wot.Yang
 * @CreateDate 2022/9/6
 * @Organization: Wot
 */
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}