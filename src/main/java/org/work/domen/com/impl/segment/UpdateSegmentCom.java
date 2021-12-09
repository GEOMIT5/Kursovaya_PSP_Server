package org.work.domen.com.impl.segment;

import org.work.domen.com.Com;
import org.work.domen.entity.Segment;
import org.work.domen.message.Message;
import org.work.domen.service.SegmentService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class UpdateSegmentCom implements Com {

    private SegmentService segmentService = ServiceFactory.getInstance().getSegmentService();

    @Override
    public Message execute(Message request) {
        Segment segment = (Segment) request.getByKey("segment");

        Message response = new Message();
        try {
            segmentService.updateSegment(segment);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }
        return response;
    }

}
