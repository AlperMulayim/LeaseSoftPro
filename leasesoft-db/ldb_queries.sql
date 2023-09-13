
SELECT L.id,L.building_id, B.city, B.block_name ,L.price,L.price_unit FROM ldb_listings L
INNER JOIN ldb_buildings AS B
 ON B.id = building_id && B.num_bedrooms = 3
WHERE L.price > 98000;