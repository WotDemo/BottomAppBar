package wot.demo.bottom_app_bar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import wot.demo.bottom_app_bar.databinding.ActionActivityBinding

/**
 * @Description 花样处理
 * @Author Wot.Yang
 * @CreateDate 2022/9/6
 * @Organization: Wot
 */
class ActionActivity : AppCompatActivity() {

    private lateinit var binding: ActionActivityBinding
    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

    private val addVisibilityChanged: FloatingActionButton.OnVisibilityChangedListener =
        object : FloatingActionButton.OnVisibilityChangedListener() {

            override fun onShown(fab: FloatingActionButton) {
                super.onShown(fab)
            }

            override fun onHidden(fab: FloatingActionButton) {
                super.onHidden(fab)
                fab.run {
                    setImageDrawable(
                        if (currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                            ContextCompat.getDrawable(this@ActionActivity, R.drawable.ic_reply_white_24dp)
                        else ContextCompat.getDrawable(this@ActionActivity, R.drawable.ic_add_white_24dp)
                    )
                    show()
                }
                binding.bottomAppBar.run {
                    currentFabAlignmentMode = fabAlignmentMode
                    fabAlignmentMode = currentFabAlignmentMode.xor(1)
                    replaceMenu(
                        if (currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) R.menu.action_activity_menu_second
                        else R.menu.action_activity_menu_first
                    )
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActionActivityBinding.inflate(layoutInflater).apply {
            setContentView(root)
            setSupportActionBar(bottomAppBar)
            initView()
        }
    }

    private fun ActionActivityBinding.initView() {
        toggleBtn.setOnClickListener {
            fab.hide(addVisibilityChanged)
            // 使菜单栏无效
            invalidateOptionsMenu()
            bottomAppBar.navigationIcon = if (bottomAppBar.navigationIcon != null) null
            else ContextCompat.getDrawable(this@ActionActivity, R.drawable.ic_menu_white_24dp)
            val firstText = getString(R.string.text_first_page)
            val secondText = getString(R.string.text_second_page)
            when (countView.text) {
                firstText -> countView.text = secondText
                secondText -> countView.text = firstText
            }
        }

        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_search -> toast(getString(R.string.format_text_click, "${it.title}"))
                R.id.app_bar_mail -> toast(getString(R.string.format_text_click, "${it.title}"))
                R.id.app_bar_delete -> toast(getString(R.string.format_text_click, "${it.title}"))
                R.id.app_bar_archive -> toast(getString(R.string.format_text_click, "${it.title}"))
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_activity_menu_first, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                ActionActivityBottomSheet().show(supportFragmentManager, ActionActivityBottomSheet().tag)
            }
        }
        return true
    }
}