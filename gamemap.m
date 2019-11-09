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
%creat a map
map(200,200) = uint8(1);

%read a map image and convert to bw
image  = imread('m2.png');

% gs  = rgb2gray(image);
bw = im2bw(image,0.5);

%set the map to the black and white image
map = bw;

%set a pixel in the map
x= 136; 
y=135;

%draw player to screen
for i=0 : 10
    for j=0 : 10
        map(x+i,y+j) = black;
    end
end


imshow(map);

%game looop for user input
while true
    %get input from keyboard
    k = waitforbuttonpress;
    value = double(get(gcf,'CurrentCharacter'));
  
   
     
    %determine keyboard inputs 
   % 28 leftarrow
   if value==28    
       if map(x,y-displacement) == white
                map = drawPixel(map,x,y,white);
                y = y-displacement;
                map = drawPixel(map,x,y,black);   
           else
               st = "Theres an obstacle"
       end
   end   
    % 29 rightarrow
   if value==29
           if map(x,y+displacement) == white
                map = drawPixel(map,x,y,white);
                y = y+displacement;
                map = drawPixel(map,x,y,black);  
           else
               st = "Theres an obstacle"
           end
   end
   
   % 30 uparrow
   if value==30
        if map(x-displacement,y) == white
            map = drawPixel(map,x,y,white);
            x = x-displacement;
            map = drawPixel(map,x,y,black);  
        else
             st = "Theres an obstacle"
       end
   end
   
   % 31 Downarrow
   if value==31
        if map(x+displacement,y) == white
            map = drawPixel(map,x,y,white);
            x = x+displacement;
            map = drawPixel(map,x,y,black);  
         else
             st = "Theres an obstacle"
       end
   end
   
   
   %if Escape key is pressed, break the program
     if value==27
       break;
     end
   
   imshow(map);
end


%Draw pixel function 
function map =  drawPixel(map,x,y,color)
    for i=0 : 10
        for j=0 : 10
            map(x+i,y+j) = color;
        end
    end
end