package com.zappycode.budgetlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager : LinearLayoutManager
    lateinit var adapter : BudgetAdapter
    lateinit var priceAdapter : BudgetPriceAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.title = "THE BUDGET"

        fab.setOnClickListener { view ->
            val intent = Intent(this,CreateBudgetActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        updateRecycler()
    }

    fun updateRecycler() {
        var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), MODE_PRIVATE)
        var budgets = prefs.getStringSet(getString(R.string.BUDGET_STRINGS),setOf()).toMutableSet()
        var budgetprice = prefs.getStringSet(getString(R.string.BUDGETPRICE_STRINGS),setOf()).toMutableSet()

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = BudgetAdapter(budgets.toList())
        priceAdapter = BudgetPriceAdapter(budgetprice.toList())

        recyclerView.adapter = adapter
        recyclerView.adapter = priceAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_delete_all) {
            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            prefs.edit().putStringSet(getString(R.string.BUDGET_STRINGS), null).apply()
            updateRecycler()

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
