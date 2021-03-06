package team12.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team12.stockist.model.UsageRecord;
import team12.stockist.repository.UsageRecordRepository;

@Service
public class UsageRecordServiceImpl implements UsageRecordService {

	@Resource
	UsageRecordRepository usageRecordRepository;

	@Override
	@Transactional
	public ArrayList<UsageRecord> findAllUsageRecord() {
		ArrayList<UsageRecord> usageRecords = (ArrayList<UsageRecord>) usageRecordRepository.findAll();
		return usageRecords;
	}

	@Override
	@Transactional
	public UsageRecord findUsageRecordById(Integer Id) {
		return usageRecordRepository.findOne(Id);
	}

	@Override
	@Transactional
	public UsageRecord createUsageRecord(UsageRecord usageRecord) {
		return usageRecordRepository.saveAndFlush(usageRecord);
	}

	@Override
	@Transactional
	public UsageRecord updateUsageRecord(UsageRecord usageRecord) {
		return usageRecordRepository.saveAndFlush(usageRecord);
	}

	@Override
	@Transactional
	public void deleteUsageRecord(UsageRecord usageRecord) {
		usageRecordRepository.delete(usageRecord);
	}

}
