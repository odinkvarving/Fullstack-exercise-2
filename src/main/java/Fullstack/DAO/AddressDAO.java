package Fullstack.DAO;

import Fullstack.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressDAO {

    private JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(AddressDAO.class);

    RowMapper<Address> rowMapper = (rs, rowNum) -> {
        Address address = new Address();
        address.setId(rs.getInt("id"));
        address.setAddressname(rs.getString("addressname"));
        address.setZipcode(rs.getInt("zipcode"));
        return address;
    };

    public AddressDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Address getAddressById(int id) {
        String sql = "SELECT id, addressname, zipcode FROM address WHERE id = ?";
        Address address = null;
        try {
            address = (Address)jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }catch (DataAccessException e) {
            log.info("Address not found" + id);
        }
        return address;
    }
}
