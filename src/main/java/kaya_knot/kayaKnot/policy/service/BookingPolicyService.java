package kaya_knot.kayaKnot.policy.service;

import kaya_knot.kayaKnot.policy.entity.BookingPolicy;

import java.util.List;
import java.util.Optional;

public interface BookingPolicyService {
    BookingPolicy createNewBookingPolicy(BookingPolicy bookingPolicy);
    List<BookingPolicy> fetchingBookingPolicy();
    Optional<BookingPolicy> fetchingBookingPolicyById(final String id);
     BookingPolicy updateBookingPolicy(BookingPolicy bookingPolicy);
}
