package org.work.domen.com.impl.segment;

import org.work.domen.com.Com;
import org.work.domen.entity.Segment;
import org.work.domen.message.Message;
import org.work.domen.service.SegmentService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

import java.util.List;

public class GetAllSegmentsCom implements Com {

    private SegmentService segmentService = ServiceFactory.getInstance().getSegmentService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<Segment> segments = segmentService.getAllSegments();
            response.add("segments", segments);
        } catch (ServiceException e) {
            response.add("ex", "can`t get all departments");
        }
        return response;
    }


}
