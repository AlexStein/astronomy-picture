package ru.softmine.astronomypicture.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.softmine.astronomypicture.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var vb: FragmentSettingsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSettingsBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

}
