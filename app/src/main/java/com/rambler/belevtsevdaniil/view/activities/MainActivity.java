package com.rambler.belevtsevdaniil.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rambler.belevtsevdaniil.R;
import com.rambler.belevtsevdaniil.model.data.RssModel;

import org.simpleframework.xml.core.Persister;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {

    String xml = "<rss version=\"2.0\">\n" +
            "<channel>\n" +
            "<title>Газета.Ru - Хроника дня</title>\n" +
            "<link>http://www.gazeta.ru/news/lenta/</link>\n" +
            "<description>\n" +
            "Новости в режиме он-лайн из всех областей жизни. Собственная информация, а также сообщения крупнейших российских и мировых информационных агентств\n" +
            "</description>\n" +
            "<pubDate>Sat, 30 Apr 2016 19:00:08 +0300</pubDate>\n" +
            "<language>ru</language>\n" +
            "<copyright>Gazeta.Ru</copyright>\n" +
            "<webMaster>webmaster@gazeta.ru</webMaster>\n" +
            "<ttl>20</ttl>\n" +
            "<item>\n" +
            "<title>\n" +
            "Минсельхоз зафиксировал гибель озимых в 2016 году на уровне 1 млн га\n" +
            "</title>\n" +
            "<link>\n" +
            "http://www.gazeta.ru/business/news/2016/04/30/n_8580131.shtml\n" +
            "</link>\n" +
            "<author>Газета.Ru</author>\n" +
            "<pubDate>Sat, 30 Apr 2016 18:49:15 +0300</pubDate>\n" +
            "<description>\n" +
            "Гибель озимых культур в текущем году к настоящему времени составила 1 млн га. Об этом сообщил директор департамента растениеводства, механизации, химизации и защиты растений Минсельхоза Петр Чекмарев по итогам сессии ...\n" +
            "</description>\n" +
            "<guid>\n" +
            "http://www.gazeta.ru/business/news/2016/04/30/n_8580131.shtml\n" +
            "</guid>\n" +
            "</item>\n" +
            "<rss2lj:owner xmlns:rss2lj=\"http://rss2lj.net/NS\">gazeta_admin</rss2lj:owner>\n" +
            "</channel>\n" +
            "</rss>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.hello);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reader reader = new StringReader(xml);
                Writer writer = new StringWriter();
                Persister persister = new Persister();
                try {
//                    ChannelModel channelModel = new ChannelModel("hello", "hello");
//                    persister.write(channelModel,writer);
//                    String string = writer.toString();
//                    System.out.println(string);
                    RssModel rssModel = persister.read(RssModel.class,reader, false);
                    textView.setText(rssModel.getChannel().getTitle());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

    }
}
