package ru.softmine.astronomypicture.ui.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.softmine.astronomypicture.R
import ru.softmine.astronomypicture.databinding.LayoutBottomNavigationBinding

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private var vb: LayoutBottomNavigationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = LayoutBottomNavigationBinding.inflate(inflater, container, false).also {
        vb = it
    }.root


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vb?.navigationView?.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
                R.id.navigation_two -> Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}
