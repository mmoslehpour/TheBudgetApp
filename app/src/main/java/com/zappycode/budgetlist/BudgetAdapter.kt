package com.zappycode.budgetlist

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.budget_row.view.*

class BudgetAdapter(val budgets: List<String>) : RecyclerView.Adapter<BudgetAdapter.BudgetHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BudgetHolder {
        return BudgetHolder(LayoutInflater.from(p0.context).inflate(R.layout.budget_row, p0, false))
    }

    override fun getItemCount(): Int {
        return budgets.count()
    }

    override fun onBindViewHolder(p0: BudgetHolder, p1: Int) {
        val title = budgets[p1]
        //val price = budgetsPrice[p1]
        p0.run {
            bindBudget(title)
           // bindBudget(price)
        }
    }

    class BudgetHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener  {

        var view : View = v
        var title : String = ""
     //   var price : Double = 0.0

        init {
            v.setOnClickListener(this)
        }

        fun bindBudget(title:String) {
            this.title = title
           // this.price = price
            view.textView.text = title
           // view.priceView.text= price.toString()
        }

        override fun onClick(v: View?) {
            val intent = Intent(view.context, CompleteBudgetActivity::class.java)
            intent.putExtra("title", title)
           // intent.putExtra("price",price)
            startActivity(view.context,intent, null)
        }

    }
}

class BudgetPriceAdapter(val budgetprice: List<String>) : RecyclerView.Adapter<BudgetPriceAdapter.BudgetPriceHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BudgetPriceHolder {
        return BudgetPriceHolder(LayoutInflater.from(p0.context).inflate(R.layout.budget_row, p0, false))
    }

    override fun getItemCount(): Int {
        return budgetprice.count()
    }

    override fun onBindViewHolder(p0: BudgetPriceHolder, p1: Int) {
        //val title = budgets[p1]
        val price = budgetprice[p1]
        p0.run {
         //   bindBudget(title)
            bindBudgetPrice(price)
        }
    }

    class BudgetPriceHolder(v:View) : RecyclerView.ViewHolder(v), View.OnClickListener  {

        var view : View = v
     //   var title : String = ""
        var price : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindBudgetPrice(price: String) {
           // this.title = title
            this.price = price
           // view.textView.text = title
            view.priceView.text= price
        }

        override fun onClick(v: View?) {
            val intent = Intent(view.context, CompleteBudgetActivity::class.java)
       //     intent.putExtra("title", title)
            intent.putExtra("price",price)
            startActivity(view.context,intent, null)
        }

    }
}
