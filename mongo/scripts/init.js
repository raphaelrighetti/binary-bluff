db.createUser({
  user: 'rapha',
  pwd: 'abc@1234',
  roles: [{ role: 'readWrite', db: 'naonaoa' }],
});

db.createCollection('mensagens', { capped: false });
db.createCollection('respostas', { capped: false });
