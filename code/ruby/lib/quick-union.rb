class QuickUnionUF

  def initialize(number_of_objects)
    @id = (0...number_of_objects).to_a
  end

  def union(first, second)
    @id[first] = @id[second]
  end

  def connected?(first, second)
    root(first) == root(second)
  end

  def root(index)
    return index if @id[index] == index
    root(@id[index])
  end
end
