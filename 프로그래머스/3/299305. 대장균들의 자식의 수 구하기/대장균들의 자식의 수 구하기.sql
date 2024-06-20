select p.ID,
    (select count(*)
    from ecoli_data
    where parent_id = p.ID) as CHILD_COUNT
from ecoli_data p order by p.ID;