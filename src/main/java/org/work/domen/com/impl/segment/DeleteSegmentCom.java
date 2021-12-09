package org.work.domen.com.impl.segment;

import org.work.domen.com.Com;
import org.work.domen.message.Message;
import org.work.domen.service.SegmentService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class DeleteSegmentCom implements Com {
    private SegmentService segmentService = ServiceFactory.getInstance().getSegmentService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        String segmentId = (String) request.getByKey("segmentId");

        try {
            segmentService.deleteSegment(segmentId);
        } catch (ServiceException e) {
            response.add("ex", "can`t delete category");
        }
        return response;
    }


}
