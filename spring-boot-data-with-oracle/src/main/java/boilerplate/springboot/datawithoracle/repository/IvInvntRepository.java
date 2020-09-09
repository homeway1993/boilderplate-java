package boilerplate.springboot.datawithoracle.repository;

import boilerplate.springboot.datawithoracle.entity.IvInvnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IvInvntRepository extends JpaRepository<IvInvnt, String> {

    @Modifying
    @Query(value = "update sys_poss.IV_INVNT set INVNT_STAT_CDE = ?1 where INVNT_ID in (?2)", nativeQuery = true)
    void updateStatusCodeByInventoryIds(String statusCode, List<String> inventoryIds);
}
