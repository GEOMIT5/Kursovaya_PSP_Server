package org.work.domen.service.impl;

import org.work.dao.SegmentRepository;
import org.work.dao.exception.DAOException;
import org.work.dao.factory.RepositoryFactory;
import org.work.domen.entity.Segment;
import org.work.domen.service.SegmentService;
import org.work.domen.service.exception.ServiceException;

import java.util.List;

public class SegmentServiceImpl implements SegmentService {

    private SegmentRepository segmentRepository = RepositoryFactory.getInstance().getSegmentRepository();

    @Override
    public void addNewSegment(Segment segment) throws ServiceException {
        try {
            segmentRepository.add(segment);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public void deleteSegment(String segmentId) throws ServiceException {
        try {
            segmentRepository.removeById(segmentId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateSegment(Segment segment) throws ServiceException {
        try {
            segmentRepository.update(segment);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Segment> getAllSegments() throws ServiceException {
        try {
            return segmentRepository.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
