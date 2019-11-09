%clear the screen before loadin map
clear

%constants 
black = 0;
white = 1;
LEFT = 0;
RIGHT = 1;
UP = 2;
DOWN = 3;
displacement = 10;

%read a map image and convert to bw
image  = imread('m3.png');

% gs  = rgb2gray(image);
bw = im2bw(image,0.5);

%set the map to the black and white image
map = bw;

%set a pixel in the map
x= 136; 
y=135;

map = drawPixel(map,x,y,black);

%display map
imshow(map)

while true
    %get input from keyboard
    k = waitforbuttonpress;
    value = double(get(gcf,'CurrentCharacter'));
  
   
     
    %determine keyboard inputs 
   % 28 leftarrow
   if value==28    
                map = drawPixel(map,x,y,white);
                y = y-displacement;
                map = drawPixel(map,x,y,black);   
           
   end   
   
    % 29 rightarrow
   if value==29
         
                map = drawPixel(map,x,y,white);
                y = y+displacement;
                map = drawPixel(map,x,y,black);  
         
   end
   imshow(map)

end

%Draw pixel function 
function map =  drawPixel(map,x,y,color)
    for i=0 : 10
        for j=0 : 10
            map(x+i,y+j) = color;
        end
    end
end