-- Insert Users (passwords encoded)
INSERT INTO user (id, username, password, role) VALUES
(1, 'admin', '$2a$10$rnwMDKVBAyAIqVAVNmzSkeNyzhRssmAkAo7cHzHMs0uj8Sf9YCWiq', 'ADMIN'),
(2, 'guest1', '$2a$10$Kxy/d0V1yRrLyg4wVNigIu6emuMzBZ8M1vRPbPnDyhnH1Cac4wlfG', 'GUEST'),
(3, 'guest2', '$2a$10$780aypb.OZ/cUVfXIIDFK.UdnMpEKtmApGZtqQp0qUjGECEGSFi3e', 'GUEST');

-- Insert properties
INSERT INTO properties (id, name, description, location, dailyPrice) VALUES
(1, 'Burj Khalifa', 'Tallest building in the world', 'Dubai', 2000),
(2, 'Modern apartment', 'A nice apartment for one person or two people', 'New York', 125),
(3, 'Cozy cabin', 'A large cabin to stay some days with your friends', 'Yukon', 100)