db = db.getSiblingDB('rvt');
db.createUser(
  {
    user: 'root',
    pwd: 'root',
    roles: [{ role: 'readWrite', db: 'rvt' }],
  },
);