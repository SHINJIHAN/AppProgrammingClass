package com.example.fragmentbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentbasic.databinding.FragmentElepBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ElephantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ElephantFragment : Fragment() {
    private lateinit var binding: FragmentElepBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    // 프래그먼트 객체가 메모리에 생성될 때 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {   // 액티비티에서 전달받은 인자를 읽어오기
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    // 프로그래먼트 객체에 레이아웃 뷰를 연결하기
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElepBinding
            .inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_elep, container, false)
    }
    // 프래그먼트 객체에 레이아웃 뷰를 연결하고 난 뒤 호출
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 프래그먼트 뷰에 추가로 해야될 작업들을 여기에 작성
        //view.findViewById<TextView>(R.id.textView).text = "Big Elephant!"
        binding.textView.text = "Big Elephant!"
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ElephantFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ElephantFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}