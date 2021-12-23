package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.ArticleMapper;
import cn.cmaple.mainsver.model.Article;
import cn.cmaple.mainsver.model.Config;
import cn.cmaple.mainsver.tools.RandomData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: JsoupService
 * @Description: 爬虫服务类
 * @author: CMAPLE
 * @date 2021/12/22 上午14:17
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Service
public class JsoupService {

    /**
     * 引入OperationLogMapper
     */
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private Config config;


    /**
     * @return void
     * @throws null
     * @Description 抓取zaker新闻的域名
     * @Title: JsoupNews
     * @author CMAPLE
     * @date 2021/12/22 下午14:19
     */
    public void JsoupNews() {
        System.out.println("INFO - " + LocalDateTime.now() + "... 开始抓取网站数据！");
        List<Article> articles = new ArrayList<Article>();
        try {
            Document html = Jsoup.connect(config.getNEWS_URLS()).get();
            Elements elements = html.getElementsByClass("carousel-inner").select("a.carousel");
            for (Element element : elements) {
                articles.add(new Article(0, RandomData.getRandomData().getRandomNHData(6), "0", "congfeng12@163.com", element.attr("title"), "", "http:" + element.attr("href"), new Date(), ""));
                System.out.println("INFO - " + LocalDateTime.now() + "获取头条标题 - " + element.attr("title"));
            }
            // 数据处理
            for (Article article : articles) {
                // 防止网站拒绝，进行请求时间间隔限制
                Thread.sleep(1000);
                QueryWrapper<Article> wrapper = new QueryWrapper<Article>();
                wrapper.eq("url", article.getUrl());
                if (articleMapper.selectCount(wrapper) == 0) {
                    Document a_html = null;
                    try {
                        // 获取相应新闻网站内容
                        a_html = Jsoup.connect(article.getUrl()).get();
                    } catch (IOException e) {
                        System.out.println("ERROR - " + LocalDateTime.now() + "请求独立新闻页面异常 - " + e.getMessage());
                    }
                    // 获取新闻内容
                    Element element_con = a_html.getElementById("content");
                    article.setContent(element_con.toString());
                    // 获取新闻作者
                    Elements elementart = a_html.getElementsByClass("article-auther line");
                    article.setAuthor(elementart.get(0).text());
                    System.out.println("INFO - " + LocalDateTime.now() + "新闻信息整理完成索引 - " + article.getAid());
                    articleMapper.insert(article);
                } else {
                    System.out.println("INFO - " + LocalDateTime.now() + "相同数据不做处理！");
                }
            }
            System.out.println("INFO - " + LocalDateTime.now() + "... 完成抓取网站数据！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR - " + LocalDateTime.now() + "请求头条页面异常 - " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("ERROR - " + LocalDateTime.now() + "线程睡眠异常 - " + e.getMessage());
        }
    }
}
