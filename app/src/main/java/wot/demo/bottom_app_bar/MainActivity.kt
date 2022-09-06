package wot.demo.bottom_app_bar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import wot.demo.bottom_app_bar.databinding.MainActivityBinding

/**
 * @Description 主页
 * @Author Wot.Yang
 * @CreateDate 2022/9/6
 * @Organization: Wot
 */
class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityBinding.inflate(layoutInflater).run {
            setContentView(root)
            setSupportActionBar(bottomAppBar)
            initView()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> MainActivityBottomSheet().show(supportFragmentManager, MainActivityBottomSheet().tag)
            R.id.menu_next_page -> startActivity(Intent(this, ActionActivity::class.java))
            R.id.menu_favorite -> toast(getString(R.string.format_text_click, "${item.title}"))
            R.id.menu_search -> toast(getString(R.string.format_text_click, "${item.title}"))
            R.id.menu_settings -> toast(getString(R.string.format_text_click, "${item.title}"))
        }
        return true
    }

    private fun MainActivityBinding.initView() {
        countView.text = getString(R.string.format_text_click_count, "0")
        fab.setOnClickListener {
            count++
            countView.text = getString(R.string.format_text_click_count, count.toString())
        }
    }
}