package org.work.domen.service;

import org.work.domen.entity.Segment;
import org.work.domen.service.exception.ServiceException;

import java.util.List;

public interface SegmentService {

    void addNewSegment(Segment segment) throws ServiceException;

    void updateSegment(Segment segment) throws ServiceException;

    void deleteSegment(String segmentId) throws ServiceException;

    List<Segment> getAllSegments() throws ServiceException;
}
