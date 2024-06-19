package kaya_knot.kayaKnot.policy.service.impl;

import kaya_knot.kayaKnot.policy.entity.BookingPolicy;
import kaya_knot.kayaKnot.policy.repo.BookingPolicyRepo;
import kaya_knot.kayaKnot.policy.service.BookingPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingPolicyServiceImpl implements BookingPolicyService {
    @Autowired
    private BookingPolicyRepo bookingPolicyRepo;
    @Override
    public BookingPolicy createNewBookingPolicy(BookingPolicy bookingPolicy) {
        return bookingPolicyRepo.save(bookingPolicy);
    }

    @Override
    public List<BookingPolicy> fetchingBookingPolicy() {
        return bookingPolicyRepo.findAll();
    }

    @Override
    public Optional<BookingPolicy> fetchingBookingPolicyById(final String id) {
        return bookingPolicyRepo.findById(id);
    }

    @Override
    public BookingPolicy updateBookingPolicy(BookingPolicy bookingPolicy) {
        return bookingPolicyRepo.save(bookingPolicy);
    }
}
