
-- Inserting Grants
INSERT INTO `oauth`.`grants` (`id`, `grant_name`) VALUES ('1', 'password');
INSERT INTO `oauth`.`grants` (`id`, `grant_name`) VALUES ('2', 'client_credentials');
INSERT INTO `oauth`.`grants` (`id`, `grant_name`) VALUES ('3', 'refresh_token');
INSERT INTO `oauth`.`grants` (`id`, `grant_name`) VALUES ('4', 'authorization_code');
INSERT INTO `oauth`.`grants` (`id`, `grant_name`) VALUES ('5', 'implicit');

-- Inserting scopes
INSERT INTO `oauth`.`scope` (`id`, `scope`) VALUES ('1', 'read');
INSERT INTO `oauth`.`scope` (`id`, `scope`) VALUES ('2', 'write');
INSERT INTO `oauth`.`scope` (`id`, `scope`) VALUES ('3', 'trust');

-- Inserting Roles
INSERT INTO `oauth`.`role` (`id`, `role`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `oauth`.`role` (`id`, `role`) VALUES ('2', 'ROLE_USER');

-- Tying scopes to roles
INSERT INTO `oauth`.`role_scope` (`role_id`, `scope_id`) VALUES ('1', '1');
INSERT INTO `oauth`.`role_scope` (`role_id`, `scope_id`) VALUES ('1', '2');
INSERT INTO `oauth`.`role_scope` (`role_id`, `scope_id`) VALUES ('1', '3');
INSERT INTO `oauth`.`role_scope` (`role_id`, `scope_id`) VALUES ('2', '1');

-- Client Info
INSERT INTO `oauth`.`oauth_client_details` (`client_id`, `access_token_validity`, `account`, `autoApprove`, `client_secret`, `refresh_token_validity`, `resource_ids`) 
VALUES ('abc@mail.com', '600', 'MYCOMP', 1, '$2a$06$QpJRaWchCY3T/3eK2gTDHOHVisGhk0go0npFGaWkem5VzU9xjgoiW', '6000', 'my-gateway');

-- Attaching roles and grants to client. Here client is admin with grant type client_credentials and refresh_token
INSERT into oauth.client_role VALUES ("abc@mail.com",1);
INSERT INTO `oauth`.`client_grant` (`client_id`, `grant_id`) VALUES ('abc@mail.com', '2');
INSERT INTO `oauth`.`client_grant` (`client_id`, `grant_id`) VALUES ('abc@mail.com', '3');
