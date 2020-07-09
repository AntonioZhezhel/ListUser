package com.example.listuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.imageViewProfileUser
import kotlinx.android.synthetic.main.activity_profile.textViewProfileUserName
import kotlinx.android.synthetic.main.item_view.view.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val photoProfile =  intent.extras?.getString ("photoProfile")
        val name =  intent.extras?.getString("name")
        val age =  intent.extras?.getInt("age")
        val cellPhone =  intent.extras?.getString("cellPhone")
        val email =  intent.extras?.getString("email")
        val skype =  intent.extras?.getString("skype")

        Picasso.get().load(photoProfile).into(imageViewProfileUser)
        textViewProfileUserName.text=name
        textViewAgeUser.text= age.toString()+"  year sold"
        textViewCellUser.text= "+$cellPhone"
        textViewEmailUser.text=email
        textViewSkypeUser.text=skype

    }

}