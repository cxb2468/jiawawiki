package com.jiawa.wiki.service;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.EbookResp;
import com.jiawa.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Cxb
 * @Date 2022-04-07 16:08
 */

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){

        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if(!ObjectUtils.isEmpty(req.getName())){
            criteria.andNameLike("%"+req.getName()+"%");
            List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);


//          List<EbookResp> respList = new ArrayList<>();
//          for (Ebook ebook : ebookList) {
////            EbookResp ebookResp = newd EbookResp();
////            BeanUtils.copyProperties(ebook,ebookResp);
////            ebookResp.setId(123456L);
//            EbookResp ebookResp =CopyUtil.copy(ebook,EbookResp.class);
//            respList.add(ebookResp);
//        }
            List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);
            return  respList;
        }else {
            List<Ebook> ebookList1 = ebookMapper.selectByExample(null);
            List<EbookResp> respList = CopyUtil.copyList(ebookList1,EbookResp.class);
            return  respList;


        }
    }
}