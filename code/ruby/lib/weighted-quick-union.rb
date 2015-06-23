class WeightedQU

  def initialize(number_of_objects)
    @id = (0...number_of_objects).to_a
    @sz = Array.new(number_of_objects, 1)
  end

  def union(first, second)
    a = root(first)
    b = root(second)
    return if a == b
    if @sz[a] < @sz[b]
      @id[a] = b
      @sz[b] += @sz[a]
    else
      @id[b] = a
      @sz[a] += @sz[b]
    end
  end

  def connected?(first, second)
    root(first) == root(second)
  end

  def root(index)
    return index if @id[index] == index
    @id[index] = @id[@id[index]]
    root(@id[index])
  end
end

