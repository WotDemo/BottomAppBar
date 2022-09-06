package wot.demo.bottom_app_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import wot.demo.bottom_app_bar.databinding.ActionActivityBottomSheetBinding

/**
 * @Description 花样处理#抽屉弹窗
 * @Author Wot.Yang
 * @CreateDate 2022/9/6
 * @Organization: Wot
 */
class ActionActivityBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ActionActivityBottomSheetBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ActionActivityBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            navigationView.setNavigationItemSelectedListener {
                dismiss()
                activity?.toast("${it.title}")
                true
            }
            navDismissBtn.setOnClickListener {
                dismiss()
            }
        }
    }
}