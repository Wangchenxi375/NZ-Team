package com.qf.handler;

import com.qf.constant.RabbitConstant;
import com.qf.dto.TProductAddDTO;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SearchHandler {

    @Autowired
    private SolrClient solrClient;
    //@RabbitHandler注解来指定对消息的处理方法
//这个类对队列的监听
    @RabbitListener(queues = RabbitConstant.PRODUCT_ADD_TO_SEARCH_QUEUE)
    public void addProductToSearch(TProductAddDTO product){
//        if(obj!=null){
//            TProductAddDTO product = (TProductAddDTO) obj;

            //2.封装成SolrInputDocument
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id",product.getPid().toString());
            document.setField("t_product_name",product.getPname());
            document.setField("t_product_sale_price",product.getSalePrice().floatValue());
            document.setField("t_product_pimage",product.getPimage());
            document.setField("t_product_pdesc",product.getPdesc());
            //3.插入到solr库里
            try {
                solrClient.add(document);
                solrClient.commit();
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//    }

}
