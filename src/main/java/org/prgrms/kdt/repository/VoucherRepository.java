package org.prgrms.kdt.repository;

import java.util.Optional;
import java.util.UUID;
import org.prgrms.kdt.domain.voucher.Voucher;

public interface VoucherRepository {

    Voucher insert(Voucher voucher);

    Optional<Voucher> findById(UUID voucherId);
}
