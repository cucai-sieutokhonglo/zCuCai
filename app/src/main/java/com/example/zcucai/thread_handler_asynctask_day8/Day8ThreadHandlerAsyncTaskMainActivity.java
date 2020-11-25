package com.example.zcucai.thread_handler_asynctask_day8;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zcucai.R;

import java.lang.ref.WeakReference;

public class Day8ThreadHandlerAsyncTaskMainActivity extends AppCompatActivity {

    static TextView tvHandler, tvHandlerProcess;
    //    Bitmap mBitmap;
    Button btnClickMe;
    //Cach 1: Subclass and overriding run() method
    Thread myThread1 = new Thread() {
        @Override
        public void run() {
            super.run();
            loadData();
            //gay force close
//            btnClickMe.setBackgroundResource(R.drawable.ic_baseline_bluetooth_searching_24);
//            btnClickMe.setText("ABC changed.");

            //pass loi force/ cap nhat trong UiTHread
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    //update UI thread.
//                    btnClickMe.setBackgroundResource(R.drawable.ic_baseline_bluetooth_searching_24);
//                }
//            });

            btnClickMe.postDelayed((new Runnable() {
                @Override
                public void run() {

                    btnClickMe.setBackgroundResource(R.drawable.ic_baseline_bluetooth_searching_24);
                    btnClickMe.setBackgroundColor(Color.BLACK);
                }
            }), 5000);
            btnClickMe.post((new Runnable() {
                @Override
                public void run() {

                    btnClickMe.setBackgroundResource(R.drawable.ic_baseline_bluetooth_searching_24);
                    btnClickMe.setBackgroundColor(Color.BLACK);
                }
            }));

        }
    };
    //Cach 2: Construct a new Thread and pass a Runnable
    Thread myThread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            loadData();
        }
    });
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    break;
                case 10:
                    Bundle bundle = msg.getData();
                    if (bundle != null) {
                        String name = bundle.getString("keyXX", "No Value");
                        tvHandler.setText(name);
                        tvHandler.setBackgroundResource(R.drawable.ic_baseline_fingerprint_24);
                    }
                    break;
            }

        }
    };


    //need more time to load the data
    public void loadData() {
        for (int i = 0; i < 10; i++) {
            Log.d("zCuCai  ", Thread.currentThread().getName() + " : i = " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day8_thread_handler_async_task_main);
        btnClickMe = findViewById(R.id.btn_clickme_day8);
        tvHandler = findViewById(R.id.tv_handler);
        tvHandlerProcess = findViewById(R.id.tv_process_handler_result);
    }

    public void threadExample(View view) {
//        myThread1.start();

        Output output = new Output();
        ThreadSample1 threadSample1 = new ThreadSample1(output, 7);
        ThreadSample2 threadSample2 = new ThreadSample2(output, 8);


        threadSample1.setName("threadSample1");
        threadSample2.setName("threadSample2");
        threadSample1.start();
        try {
            //ep thread1 chay truoc
            threadSample1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadSample2.start();

    }

    public void handlerExample(View view) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    loadData();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("keyXX", "valueXX");
                message.setData(bundle);
                message.what = 10;
                handler.sendMessage(message);

            }
        };
        thread.start();

    }
//AsyncTask example
    // Ra sau Thread: thread kho quan ly, cap nhat giao dien lang nhang kho kiem soat code

    public void asyncTaskExample(View view) {
        MyAsyncTask myAsyncTask = new MyAsyncTask((Activity) this);
        myAsyncTask.execute();

    }

    public static class MyAsyncTask extends AsyncTask<String, Integer, String> {
        WeakReference<Activity> weakReference;

        public MyAsyncTask(Activity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        protected String doInBackground(String... strings) {
            //xu ly duoi nen
            //heavy action. do in background
//            String srt1 = strings[0];
//            String str2 = strings[1];

            String result = "";
            for (int i = 0; i < 10; i++) {
                result += i + " - ";
                publishProgress(i * 100 / 10);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        @Override
        protected void onPreExecute() {
            //khoi tao giao dien
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {


            //temporary update UI
            super.onProgressUpdate(values);
            tvHandlerProcess.setText(values[0] + " % ");

        }

        @Override
        protected void onPostExecute(String string) {
            //final update
            super.onPostExecute(string);
            Activity activity = weakReference.get();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (activity.isDestroyed() || activity == null) {

                } else {

                    tvHandlerProcess.setText(string);
                }
            }
        }
    }

    //Cach 3: Tao ra 1 class  moi extend thread
    public class Thread3 extends Thread {
        int n;

        public Thread3(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            super.run();
            loadData();
        }
    }

    public class MyRunable implements Runnable {
        int n;

        public MyRunable(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            loadData();
        }
    }

    public class Output {
        public void in(int n) {
            //abc xyz
            synchronized (this) {
                for (int i = 0; i < n; i++) {
                    Log.d("zCuCai-Output", Thread.currentThread().getName() + ":" + i);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //Sample Handler

    public class ThreadSample1 extends Thread {
        Output output;
        int n;

        public ThreadSample1(Output output, int n) {
//            super(name);
            this.output = output;
            this.n = n;
        }

        @Override
        public void run() {
            super.run();
//            synchronized (output) {
            output.in(n);
//            }
        }
    }

    public class ThreadSample2 extends Thread {
        Output output;
        int n;

        public ThreadSample2(Output output, int n) {
//            super(name);
            this.output = output;
            this.n = n;
        }

        @Override
        public void run() {
            super.run();
//            synchronized (output) {
            output.in(n);
//            }
        }
    }

}