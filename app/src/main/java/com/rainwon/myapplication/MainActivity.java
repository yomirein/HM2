package com.rainwon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // задание полей
    float RobotPrice = 35_000;
    float amount = 1_700;
    float account = 700;
    float percentBank = 9;

    private TextView countOut;
    private TextView manyMonthOut;

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        countOut = findViewById(R.id.Tv1); // вывод информации количества месяцев выплаты ипотеки
        manyMonthOut = findViewById(R.id.tv2); // вывод информации выписки по ежемесячным платежам

        countOut.setText(countMonth(percentBank, account, RobotPrice, amount) + " месяцев надо работать для получения робота");

        manyMonthOut.setText("Первоначальный взнос " + account);
    }

    // метод подсчёта времени выплаты ипотеки (годовой процент, зар.плата, свободные траты, стоимость квартиры, накопления, массив для выписки по счёту)
    public int countMonth(float percentBankYear, float accumulation, float robotCost, float salary) {

        float percentBankMonth = percentBankYear / 12;
        float monthlyPayment = (accumulation * percentBankMonth) / 100 + salary;
        float total = robotCost - accumulation;
        int count = 0;

        while (total > 0) {
            count++;
            total = total - monthlyPayment;
        }

        return count;
    }
}