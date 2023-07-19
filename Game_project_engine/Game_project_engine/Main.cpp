#include <SFML/Graphics.hpp>
#include "ControlGame.h"
#include "Button_ControlGame.h"
#include "Main_menu.h"

int main() {

	sf::RenderWindow window(sf::VideoMode(1200,679), "Super Coding", sf::Style::Titlebar | sf::Style::Close);
	MainMenu mainMenu(window.getSize().x, window.getSize().y);

	//sf::RectangleShape background;
	sf::Texture backgr_textTure;
	backgr_textTure.loadFromFile("Background/image_1.jpg");
	//background.setTexture(&backgr_textTure);
	sf::Sprite sprite(backgr_textTure);

	ControlGame controlSkill("Click me", {80, 80}, sf::Color::Green, sf::Color::Black,20);
	controlSkill.setPostion({ 1230, 650 });

	while (window.isOpen())
	{
		sf::Event event;
		while (window.pollEvent(event))
		{
			if (event.type == sf::Event::Closed)
			{
				window.close();
			}

			if (event.type == sf::Event::KeyReleased)
			{
				if (event.key.code == sf::Keyboard::Up)
				{
					mainMenu.MoveUp();
					break;
				}

				if (event.key.code == sf::Keyboard::Down)
				{
					mainMenu.MoveDown();
					break;
				}

				if (event.key.code == sf::Keyboard::Return)
				{
					sf::RenderWindow Play(sf::VideoMode(NULL,NULL), "Play Game", sf::Style::Fullscreen);
					sf::RenderWindow Option(sf::VideoMode(960, 720), "Option");
					sf::RenderWindow About(sf::VideoMode(960, 720), "About");

					int x = mainMenu.MainMenuPressed();
					if (x == 0)
					{
						while (Play.isOpen())
						{
							sf::Event Aevent;
							while (Play.pollEvent(Aevent))
							{
								if (Aevent.type == sf::Event::Closed)
								{
									Play.close();
								}

								if (Aevent.type == sf::Event::KeyReleased)
								{
									if (Aevent.key.code == sf::Keyboard::Escape)
									{
										Play.close();
									}
								}

								if (Aevent.type == sf::Event::MouseMoved)
								{
									if (controlSkill.isMouseOver(Play))
									{
										controlSkill.setBackgroundColor(sf::Color::Blue);
									}
									else {
										controlSkill.setBackgroundColor(sf::Color::Black);
									}
								}
							}

							About.close();
							Option.close();
							window.close();
							Play.clear(sf::Color::Black);
							controlSkill.drawTo(Play);
							Play.display();

						}
					}

					if (x == 1)
					{
						while (Option.isOpen())
						{
							sf::Event Aevent;
							while (Option.pollEvent(Aevent))
							{
								if (Aevent.type == sf::Event::Closed)
								{
									Option.close();
								}
								if (Aevent.type == sf::Event::KeyReleased)
								{
									if (Aevent.key.code == sf::Keyboard::Escape)
									{
										Option.close();
									}
								}
							}

							Play.close();
							window.close();
							About.close();
							Option.clear(sf::Color::White);

							Option.display();

						}
					}

					if (x == 2)
					{
						while (About.isOpen())
						{
							sf::Event Aevent;
							while (About.pollEvent(Aevent))
							{
								if (Aevent.type == sf::Event::Closed)
								{
									About.close();
								}
								if (Aevent.type == sf::Event::KeyReleased)
								{
									if (Aevent.key.code == sf::Keyboard::Escape)
									{
										About.close();
									}
								}
							}

							Play.close();
							Option.close();
							window.close();

							About.clear(sf::Color::White);
							About.display();
						}
					}

					if (x == 3)
						window.close();
					break;
				}

			}

		}
		window.clear();
		window.draw(sprite);
		mainMenu.draw(window);
		window.display();
	}

	return 0;
}
