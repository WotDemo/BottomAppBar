package wot.demo.bottom_app_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import wot.demo.bottom_app_bar.databinding.MainActivityBottomSheetBinding

/**
 * @Description 主页#抽屉弹窗
 * @Author Wot.Yang
 * @CreateDate 2022/9/6
 * @Organization: Wot
 */
class MainActivityBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: MainActivityBottomSheetBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MainActivityBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigationView.setNavigationItemSelectedListener {
            dismiss()
            when (it.itemId) {
                R.id.nav1 -> context?.toast(getString(R.string.format_text_click, "${it.title}"))
                R.id.nav2 -> context?.toast(getString(R.string.format_text_click, "${it.title}"))
                R.id.nav3 -> context?.toast(getString(R.string.format_text_click, "${it.title}"))
            }
            true
        }
    }
}